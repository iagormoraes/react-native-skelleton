package com.reactnativeskelleton

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Handler
import android.view.animation.*
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.views.view.ReactViewGroup

@SuppressLint("ViewConstructor")
class SkelletonView(reactContext: ThemedReactContext) : ReactViewGroup(reactContext) {
  private val startInitialPosition = -9999f
  private val endInitialPosition = 0f
  private var repeatDelay: Long = 0
  private var measured = false

  var objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(this, "translationX", startInitialPosition, endInitialPosition)

  init {
    // set initial position to maintain the user experience
    translationX = startInitialPosition
    
    objectAnimator.addListener(SkelletonAnimatorListener())
  }

  override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {}

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    objectAnimator.setFloatValues(-(measuredWidth + 1).toFloat(), (measuredWidth + 1).toFloat())

    measured = true
  }

  fun setDuration(duration: Int) {
    objectAnimator.duration = duration.toLong()
  }

  fun setStartDelay(delay: Int) {
    objectAnimator.startDelay = delay.toLong()
  }

  fun setRepeatDelay(delay: Int) {
    repeatDelay = delay.toLong()
  }

  fun setRepeatCount(count: Int) {
    objectAnimator.repeatCount = count
  }

  fun setRepeatMode(mode: Int) {
    val repeatMode = when(mode) {
      ValueAnimator.RESTART -> ValueAnimator.RESTART
      else -> ValueAnimator.REVERSE
    }

    objectAnimator.repeatMode = repeatMode
  }

  fun setInterpolator(interpolator: String) {
    objectAnimator.interpolator = when(interpolator) {
      "AccelerateDecelerateInterpolator" -> AccelerateDecelerateInterpolator()
      "AccelerateInterpolator" -> AccelerateInterpolator()
      "AnticipateInterpolator" -> AnticipateInterpolator()
      "AnticipateOvershootInterpolator" -> AnticipateOvershootInterpolator()
      "BounceInterpolator" -> BounceInterpolator()
      "CycleInterpolator" -> CycleInterpolator(1f)
      "DecelerateInterpolator" -> DecelerateInterpolator()
      "LinearInterpolator" -> LinearInterpolator()
      "OvershootInterpolator" -> OvershootInterpolator()

      else -> AccelerateDecelerateInterpolator()
    }
  }

  fun setAutoStart(autoStart: Boolean) {
    if(measured) return

    if(autoStart) {
      objectAnimator.cancel()
      objectAnimator.start()
    }
  }

  private inner class SkelletonAnimatorListener: Animator.AnimatorListener {
    override fun onAnimationRepeat(animator: Animator?) {
      animator?.let {
        if(repeatDelay > 0) {
          it.pause()

          Handler().postDelayed(it::resume, repeatDelay)
        }
      }
    }

    override fun onAnimationEnd(animator: Animator?) {}

    override fun onAnimationCancel(animator: Animator?) {}

    override fun onAnimationStart(animator: Animator?) {}

  }
}
