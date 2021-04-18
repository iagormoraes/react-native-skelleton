import SkelletonView, { SkelletonGroupView } from 'react-native-skelleton';
import { View, ViewStyle } from 'react-native';
import * as React from 'react';

function SkelletonA({ style }: { style: ViewStyle }) {
  return (
    <SkelletonGroupView
      duration={3000}
      interpolator="BounceInterpolator"
      style={style}
    >
      <SkelletonView
        color="red"
        repeatCount={-1}
        repeatMode={1}
        style={{
          ...style,
          backgroundColor: '#C3C3C3',
        }}
      >
        <View
          style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}
        >
          <View
            style={{
              width: 10,
              height: 10,
              alignSelf: 'center',
              backgroundColor: 'yellow',
            }}
          />
        </View>
      </SkelletonView>
    </SkelletonGroupView>
  );
}

export default SkelletonA;
