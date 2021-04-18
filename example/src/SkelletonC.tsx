import * as React from 'react';
import SkelletonView from 'react-native-skelleton';
import LinearGradient from 'react-native-linear-gradient';
import type { ViewStyle } from 'react-native';

function SkelletonC({ style }: { style: ViewStyle }) {
  return (
    <SkelletonView
      repeatCount={-1}
      repeatMode={1}
      autoStart
      style={{
        ...style,
        backgroundColor: '#C3C3C3',
      }}
    >
      <LinearGradient
        start={{ x: 0, y: 0 }}
        end={{ x: 1, y: 0 }}
        colors={['rgba(119,119,119,0)', '#aeaeae', 'rgba(119,119,119,0)']}
        style={{ flex: 1, width: '50%' }}
      />
    </SkelletonView>
  );
}

export default SkelletonC;
