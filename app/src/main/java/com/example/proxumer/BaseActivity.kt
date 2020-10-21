package com.example.newbaseandroid.proxumer


import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


open class BaseActivity : AppCompatActivity()
{

    fun addFragment(id: Int, fragment: Fragment, tag: String)
    {
        supportFragmentManager.beginTransaction()
            .add(id, fragment, tag)
            .commit()
    }

    fun addFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(id, fragment, fragment.javaClass.name)
            .commit()
    }

    fun replaceFragment(id: Int, fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment, tag)
            .commit()
    }

    fun replaceFragment(id: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment, fragment.javaClass.name)
            .commit()
    }

    fun replaceFragment(id: Int, fragment: Fragment, enterAnim: Int, exitAnim: Int) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(enterAnim, exitAnim)
            .replace(id, fragment, fragment.javaClass.name)
            .commit()
    }

    fun replaceFragmentAndClearBackStack(id: Int, backStackName: String?, fragment: Fragment, tag: String) {

        supportFragmentManager.popBackStackImmediate(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        supportFragmentManager.beginTransaction()
            .replace(id, fragment, tag)
            .commit()
    }

    fun replaceFragmentAndClearBackStack(id: Int, backStackName: String?, fragment: Fragment) {
        supportFragmentManager.popBackStackImmediate(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        replaceFragment(id, fragment)
    }

    fun replaceFragmentAndClearBackStack(id: Int, fragment: Fragment, enterAnim: Int, exitAnim: Int) {
        supportFragmentManager.popBackStackImmediate(fragment.javaClass.name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        replaceFragment(id, fragment, enterAnim, exitAnim)
    }

    fun replaceFragmentWithBackStack(id: Int, fragment: Fragment, tag: String, backStackName: String?) {
        supportFragmentManager.beginTransaction()
            .replace(id, fragment, tag)
            .addToBackStack(backStackName)
            .commit()
    }

    fun replaceFragmentWithBackStack(id: Int, fragment: Fragment, enterAnim: Int, exitAnim: Int, popEnterAnim: Int, popExitAnim: Int) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim)
            .replace(id, fragment, fragment.javaClass.name)
            .addToBackStack(fragment.javaClass.name)
            .commit()
    }

    fun removeFragment(id: Int, backStackName: String?)
    {
        supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentById(id)!!).commit()
    }

    fun clearBackStack(id: Int, backStackName: String?) {
        supportFragmentManager.popBackStackImmediate(backStackName, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentById(id)!!).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }





}
