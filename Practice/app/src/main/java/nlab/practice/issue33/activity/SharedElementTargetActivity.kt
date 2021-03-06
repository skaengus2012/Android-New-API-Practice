package nlab.practice.issue33.activity

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_shared_element_target.*
import nlab.practice.R
import nlab.practice.util.GlideApp

/**
 * SharedCurrentElement 를 눌렀을 때, 나타날 화면
 *
 * @author Doohyun
 */
class SharedElementTargetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_target)

        // SHARED ELEMENT 수행 중, async image loading 에 대한 처리
        supportPostponeEnterTransition()

        GlideApp.with(this)
                .load(SHARED_ELEMENT_ACTIVITY_IMAGE_URL)
                .dontAnimate()
                .listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()

                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()

                        return false
                    }
                })
                .into(ivProfile)
    }

}
