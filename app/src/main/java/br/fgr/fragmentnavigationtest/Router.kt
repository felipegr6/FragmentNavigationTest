package br.fgr.fragmentnavigationtest

interface Router {
    fun initFlow(fragment: BaseFragment)
    fun endFlow(fragment: BaseFragment)
}