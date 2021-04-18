package com.reactnativeskelleton

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewGroupManager
import com.facebook.react.uimanager.annotations.ReactProp

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

  @ReactProp(name = "autoStart", defaultBoolean = true)
  fun setAutoStart(view: SkelletonView, autoStart: Boolean) {
    view.setAutoStart(autoStart)
  }
}

class SkelletonGroupViewManager : ViewGroupManager<SkelletonGroupView>() {
  override fun getName(): String {
    return "SkelletonGroupView"
  }

  override fun createViewInstance(reactContext: ThemedReactContext): SkelletonGroupView {
    return SkelletonGroupView(reactContext)
  }

  @ReactProp(name = "duration", defaultInt = 500)
  fun setDuration(view: SkelletonGroupView, duration: Int) {
    view.setDuration(duration)
  }

  @ReactProp(name = "startDelay", defaultInt = 0)
  fun setStartDelay(view: SkelletonGroupView, startDelay: Int) {
    view.setStartDelay(startDelay)
  }

  @ReactProp(name = "interpolator")
  fun setInterpolator(view: SkelletonGroupView, interpolator: String?) {
    interpolator?.let {
      view.setInterpolator(it)
    }
  }
}
