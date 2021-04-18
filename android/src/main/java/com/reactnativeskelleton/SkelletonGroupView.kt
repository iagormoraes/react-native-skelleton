package com.reactnativeskelleton

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.views.view.ReactViewGroup
import kotlin.collections.ArrayList


@SuppressLint("ViewConstructor")
class SkelletonGroupView(reactContext: ThemedReactContext): ReactViewGroup(reactContext) {
  private val animatorSet = AnimatorSet()
  private val objectAnimatorList = ArrayList<ObjectAnimator>()

  private fun buildAnimatorSet() {
    Handler().post {
      objectAnimatorList.clear()

      getSkelletonViewAnimator(this)

      animatorSet.playTogether(objectAnimatorList.toList())

      animatorSet.start()
    }
  }

  private fun getSkelletonViewAnimator(view: View) {
    if (view !is ViewGroup) { return }

    for (i in 0 until view.childCount) {
      val child = view.getChildAt(i)

      getSkelletonViewAnimator(child)
    }

    if(view is SkelletonView) {
      objectAnimatorList.add(view.objectAnimator)
    }
  }

  override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    buildAnimatorSet()
  }

  fun setDuration(duration: Int) {
    animatorSet.duration = duration.toLong()
  }

  fun setStartDelay(delay: Int) {
    animatorSet.startDelay = delay.toLong()
  }

  fun setInterpolator(interpolator: String) {
    animatorSet.interpolator = when(interpolator) {
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
}
