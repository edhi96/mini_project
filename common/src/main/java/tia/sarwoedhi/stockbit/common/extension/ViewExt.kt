/**
 * created by Tia Sarwoedhi on 10/9/2021
 **/

package tia.sarwoedhi.stockbit.common.extension

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.stockbit.common.R
import tia.sarwoedhi.stockbit.common.utils.Event

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun Fragment.showSnackbar(snackbarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById<View>(android.R.id.content), snackbarText, timeLength).show() }
}

/**
 * Triggers a snackbar message when the value contained by snackbarTaskMessageLiveEvent is modified.
 */
fun Fragment.setupSnackbar(lifecycleOwner: LifecycleOwner, snackbarEvent: LiveData<Event<Int>>, timeLength: Int) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackbar(it.getString(res), timeLength) }
        }
    })
}

fun TextView.changeTextColor(changesPrice: Double, context: Context) {
    this.setTextColor( if (changesPrice < 0) ContextCompat.getColor(context, R.color.red)
    else if(changesPrice>0) ContextCompat.getColor(context, R.color.green)
    else ContextCompat.getColor(context, R.color.blackFont))
}

fun View.setVisibility(conditionVisibility:Boolean){
    this.visibility = if(conditionVisibility) View.VISIBLE else View.GONE
}