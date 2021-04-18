package com.reactnativeskelleton

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Handler
import android.view.View
import android.view.animation.*
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.views.view.ReactViewGroup


@SuppressLint("ViewConstructor")
class SkelletonView(reactContext: ThemedReactContext) : ReactViewGroup(reactContext) {
  private val startInitialPosition = -9999f
  private val endInitialPosition = 0f

  private var objectAnimator: ObjectAnimator = ObjectAnimator.ofFloat(this, "translationX", startInitialPosition, endInitialPosition)
  private var repeatDelay: Long = 0

  init {
    // set initial position to maintain the user experience
    translationX = startInitialPosition

    objectAnimator.addListener(SkelletonAnimatorListener())
    objectAnimator.start()
  }

  override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {}

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    objectAnimator.setFloatValues(-(measuredWidth + 1).toFloat(), (measuredWidth + 1).toFloat())

    // this fix synchronous between the others SkelletonView animations
    objectAnimator.cancel()
    objectAnimator.start()
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

  private inner class SkelletonAnimatorListener: AnimatorListener {
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

class SkelletonViewManager : ViewGroupManager<SkelletonView>() {
  override fun getName() = "SkelletonView"

  override fun createViewInstance(reactContext: ThemedReactContext): SkelletonView {
    return SkelletonView(reactContext)
  }

  @ReactProp(name = "color")
  fun setColor(view: SkelletonView, color: String?) {
    color?.let {
      view.backgroundColor = Color.parseColor(it)
    }
  }

  @ReactProp(name = "startDelay", defaultInt = 0)
  fun setStartDelay(view: SkelletonView, startDelay: Int) {
    view.setStartDelay(startDelay)
  }

  @ReactProp(name = "repeatDelay", defaultInt = 0)
  fun setRepeatDelay(view: SkelletonView, repeatDelay: Int) {
    view.setRepeatDelay(repeatDelay)
  }

  @ReactProp(name = "duration", defaultInt = 500)
  fun setDuration(view: SkelletonView, duration: Int) {
    view.setDuration(duration)
  }

  @ReactProp(name = "repeatCount", defaultInt = ObjectAnimator.INFINITE)
  fun setRepeatCount(view: SkelletonView, repeatCount: Int) {
    view.setRepeatCount(repeatCount)
  }

  @ReactProp(name = "repeatMode", defaultInt = ValueAnimator.RESTART)
  fun setRepeatMode(view: SkelletonView, repeatMode: Int) {
    view.setRepeatMode(repeatMode)
  }

  @ReactProp(name = "interpolator")
  fun setInterpolator(view: SkelletonView, interpolator: String?) {
    interpolator?.let {
      view.setInterpolator(it)
    }
  }
}
