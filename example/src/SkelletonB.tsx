import SkelletonView from 'react-native-skelleton';
import type { ViewStyle } from 'react-native';
import * as React from 'react';

function SkelletonB({ style }: { style: ViewStyle }) {
  return (
    <SkelletonView
      color="#888888"
      repeatCount={-1}
      repeatMode={2}
      duration={1000}
      repeatDelay={1000}
      style={{
        ...style,
        backgroundColor: '#C3C3C3',
      }}
    />
  );
}

export default SkelletonB;
