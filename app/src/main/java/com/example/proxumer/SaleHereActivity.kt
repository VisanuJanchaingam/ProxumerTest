package com.example.newbaseandroid.proxumer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cp.overlayimageactionbar.*
import com.example.proxumer.R
import com.example.proxumer.databinding.ActivitySaleHereBinding

import io.socket.client.Ack
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONArray
import org.json.JSONObject

class SaleHereActivity : BaseActivity() {

    private var adapter : BottomTabAdapter ?= null
    private var socket: Socket? = null
    private val binding: ActivitySaleHereBinding by lazy { ActivitySaleHereBinding.inflate(layoutInflater) }
    private var badgeCounter = 0

    private fun initStatusBar()
    {
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.color_yellow)

    }

    private fun hideActionBar()
    {
        supportActionBar!!.hide()
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        hideActionBar()
        initStatusBar()
        initRecyclerView()
        replaceFragment(binding.contentContainer.id,HomeFragment().newInstance())

    }

        private fun initRecyclerView()
    {
        //recyclerView
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.bottomTab.layoutManager = layoutManager
        binding.bottomTab.setHasFixedSize(true)
        adapter = BottomTabAdapter( getWidthDevice(4f),object : BottomTabAdapter.OnClickMenuListener {
            override fun onClick(position: Int)
            {
                adapter!!.selectTab(position)
                when(position)
                {
                    0 -> { replaceFragmentAndClearBackStack(binding.contentContainer.id,"",HomeFragment().newInstance()) }
                    1 -> { replaceFragmentAndClearBackStack(binding.contentContainer.id,"",BlankFragment().newInstance()) }
                    2 -> { replaceFragmentAndClearBackStack(binding.contentContainer.id,"",AchievementFragment().newInstance()) }
                    3 -> { replaceFragmentAndClearBackStack(binding.contentContainer.id,"",BlankFragment().newInstance()) }
                }

            } })
        binding.bottomTab.adapter = adapter

    }


    fun getWidthDevice(size : Float) : Int
    {
        var displaymetrics =  DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displaymetrics)
        return (displaymetrics.widthPixels.toFloat() / size).toInt()
    }



    override fun onPause() {
        super.onPause()
        closeSocket()
    }


    private var onConnectError = Emitter.Listener { args ->
        Log.e("onConnectError", "Exception " + args[0])
    }


    private var onReceive = Emitter.Listener {
        try
        {
            runOnUiThread {
                badgeCounter = badgeCounter+1
                adapter!!.updateBadge(badgeCounter)
            }

            var jsonArray = JSONArray(it)
            println("json : "+jsonArray.getJSONObject(0).toString())

        }catch (e : Exception) { e.printStackTrace() }

    }


    private fun openSocket()
    {
        var url = "https://px-socket-api.herokuapp.com/"

        try {
            println("open Socket")
            socket = IO.socket(url)
        }
        catch (e: Exception)
        {
            println(e.message)
            e.printStackTrace()
        }

    }

    override fun onResume()
    {
        super.onResume()
        openSocket()
        initSocket()
    }


    private fun initSocket()
    {
        socket?.let {
            it.apply {
                on(Socket.EVENT_CONNECT_ERROR, onConnectError)
                on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError)
                on(Socket.EVENT_RECONNECT_FAILED, onConnectError)
                on(Socket.EVENT_DISCONNECT, onConnectError)
                on(Socket.EVENT_RECONNECT_ERROR, onConnectError)
                on(Socket.EVENT_CONNECT) { println("Socket.EVENT_CONNECT") }
                on(Socket.EVENT_RECONNECT, onConnectError)
                on("new-notification", onReceive)
                connect()
            }
        }
    }


    private fun closeSocket()
    {
        socket?.let {
            it.apply {
                socket!!.off(Socket.EVENT_CONNECT_ERROR, onConnectError)
                socket!!.off(Socket.EVENT_CONNECT_TIMEOUT, onConnectError)
                socket!!.off(Socket.EVENT_RECONNECT_FAILED, onConnectError)
                socket!!.off(Socket.EVENT_DISCONNECT, onConnectError)
                socket!!.off(Socket.EVENT_RECONNECT_ERROR, onConnectError)
                socket!!.off(Socket.EVENT_CONNECT)
                socket!!.off(Socket.EVENT_RECONNECT)
                socket!!.disconnect()
            }
        }
    }
}