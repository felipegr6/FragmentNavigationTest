package br.fgr.fragmentnavigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Screen04Fragment : BaseFragment() {
    override fun getIdentifier(): String? = "Screen04Fragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_screen_four, container, false)
    }

    companion object {
        const val TAG = "Screen04Fragment"
    }
}
