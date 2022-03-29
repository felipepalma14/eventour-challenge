package br.com.felipepalma14.commons.base

import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseMvvmActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var vmFactory: DaggerViewModelFactory

    inline fun <reified VM : BaseViewModel> appViewModel(): ViewModelDelegate<VM> {
        return ViewModelDelegate(VM::class, this) { this.vmFactory }
    }
}