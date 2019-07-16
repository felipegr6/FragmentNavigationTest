package br.fgr.fragmentnavigationtest

import android.os.Bundle
import android.util.Log

class MainActivity : BaseActivity() {
    override fun initFlow(fragment: BaseFragment) {
        // Add to back stack false
        // nextScreen(Action.REPLACE, Screen01Fragment(), Screen01Fragment.TAG)
        nextScreen(Action.ADD, fragment, fragment.getIdentifier() ?: "", addToBackStack = false)
    }

    override fun endFlow(fragment: BaseFragment) {
        supportFragmentManager?.fragments?.forEach {
            Log.i("xxx", it.toString())
            val manager = supportFragmentManager
            manager?.beginTransaction()?.remove(it)?.commit()
            manager.popBackStackImmediate()
        }
        nextScreen(Action.ADD, Screen04Fragment(), Screen04Fragment.TAG, addToBackStack = false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFlow(Screen01Fragment())
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
