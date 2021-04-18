import SkelletonView from 'react-native-skelleton';
import { Image, ViewStyle } from 'react-native';
import * as React from 'react';

function SkelletonD({ style }: { style: ViewStyle }) {
  return (
    <SkelletonView
      color="#00000000"
      autoStart
      repeatCount={-1}
      repeatMode={1}
      duration={1000}
      repeatDelay={3000}
      style={{
        ...style,
        backgroundColor: '#C3C3C3',
      }}
    >
      <Image
        source={{
          uri:
            'https://images.unsplash.com/photo-1552519507-da3b142c6e3d?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y2Fyc3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80',
        }}
        style={{ flex: 1 }}
      />
    </SkelletonView>
  );
}

export default SkelletonD;
