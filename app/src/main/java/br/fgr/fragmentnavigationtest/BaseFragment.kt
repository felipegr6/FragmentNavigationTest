package br.fgr.fragmentnavigationtest

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {

    abstract fun getIdentifier(): String?
    open var router: Router? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.i(getIdentifier(), "onAttach")
        router = context as? Router
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i(getIdentifier(), "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(getIdentifier(), "onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(getIdentifier(), "onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i(getIdentifier(), "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(getIdentifier(), "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(getIdentifier(), "onSaveInstanceState")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.i(getIdentifier(), "onViewStateRestored")
    }

    override fun onPause() {
        Log.i(getIdentifier(), "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(getIdentifier(), "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(getIdentifier(), "onDestroy")
        super.onDestroy()
    }

    override fun onDestroyView() {
        Log.i(getIdentifier(), "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.i(getIdentifier(), "onDetach")
        router = null
        super.onDetach()
    }
}