import SkelletonView from 'react-native-skelleton';
import { View, ViewStyle } from 'react-native';
import * as React from 'react';

function SkelletonA({ style }: { style: ViewStyle }) {
  return (
    <SkelletonView
      color="red"
      repeatCount={-1}
      repeatMode={1}
      duration={1000}
      interpolator="BounceInterpolator"
      style={{
        ...style,
        backgroundColor: '#C3C3C3',
      }}
    >
      <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
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
  );
}

export default SkelletonA;
