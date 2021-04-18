import React from 'react';
import SkelletonC from './SkelletonC';
import { View } from 'react-native';
import { SkelletonGroupView } from 'react-native-skelleton';

function ProfileSkelleton() {
  return (
    <SkelletonGroupView
      duration={1000}
      interpolator="AccelerateDecelerateInterpolator"
      style={{ flexDirection: 'row', marginBottom: 26 }}
    >
      <SkelletonC style={{ width: 50, height: 50, borderRadius: 50 }} />
      <View style={{ flex: 1, alignSelf: 'center', marginLeft: 16 }}>
        <SkelletonC
          style={{
            width: '100%',
            height: 10,
            borderRadius: 50,
          }}
        />
        <SkelletonC
          style={{
            width: '50%',
            height: 10,
            borderRadius: 50,
            marginTop: 16,
          }}
        />
      </View>
    </SkelletonGroupView>
  );
}

export default ProfileSkelleton;
