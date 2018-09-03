package nlab.practice.util.adapterview

import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes

/**
 * @author Doohyun
 * @since 2018. 07. 11
 */
interface BindAbleItem {
    @LayoutRes fun getLayoutRes() : Int

    fun setBindingBehavior(binding: ViewDataBinding){}
}