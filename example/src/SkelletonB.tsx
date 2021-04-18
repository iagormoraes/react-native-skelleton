import SkelletonView, { SkelletonGroupView } from 'react-native-skelleton';
import type { ViewStyle } from 'react-native';
import * as React from 'react';

function SkelletonB({ style }: { style: ViewStyle }) {
  return (
    <SkelletonGroupView
      duration={1000}
      interpolator="AccelerateDecelerateInterpolator"
      style={style}
    >
      <SkelletonView
        color="#888888"
        repeatCount={-1}
        repeatMode={2}
        style={{
          ...style,
          backgroundColor: '#C3C3C3',
        }}
      />
    </SkelletonGroupView>
  );
}

export default SkelletonB;
