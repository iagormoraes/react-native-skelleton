import * as React from 'react';
import { StyleSheet, View, Text, ScrollView } from 'react-native';
import SkelletonA from './SkelletonA';
import SkelletonB from './SkelletonB';
import SkelletonC from './SkelletonC';
import SkelletonD from './SkelletonD';
import ProfileSkelleton from './ProfileSkelleton';

export default function App() {
  return (
    <ScrollView contentContainerStyle={styles.container}>
      <Text style={{ fontSize: 26, marginBottom: 16 }}>RN-Skelleton</Text>
      {new Array(10).fill(undefined).map((_, index) => (
        <React.Fragment key={index}>
          <ProfileSkelleton />
          <ProfileSkelleton />
          <ProfileSkelleton />
          <SkelletonA
            style={{
              width: '100%',
              borderRadius: 50,
              height: 16,
            }}
          />
          <View style={styles.space} />
          <SkelletonA
            style={{
              alignSelf: 'flex-start',
              width: '70%',
              borderRadius: 50,
              height: 16,
            }}
          />
          <View style={styles.space} />
          <SkelletonA
            style={{
              width: '100%',
              borderRadius: 50,
              height: 16,
            }}
          />
          <View style={styles.space} />
          <View style={{ flexDirection: 'row' }}>
            <SkelletonA
              style={{
                flex: 1,
                borderRadius: 50,
                height: 16,
              }}
            />
            <View style={styles.space} />
            <SkelletonA
              style={{
                flex: 1,
                borderRadius: 50,
                height: 16,
              }}
            />
          </View>
          <View style={styles.space} />
          <SkelletonB
            style={{
              borderRadius: 50,
              width: '100%',
              height: 26,
            }}
          />
          <View style={styles.space} />
          <SkelletonB
            style={{
              borderRadius: 50,
              width: '100%',
              height: 26,
            }}
          />
          <View style={styles.space} />
          <SkelletonB
            style={{
              borderRadius: 50,
              width: '100%',
              height: 26,
            }}
          />
          <View style={styles.space} />

          <View
            style={{ flex: 1, flexDirection: 'row', alignItems: 'flex-end' }}
          >
            <SkelletonC
              style={{
                borderRadius: 50,
                flex: 1,
                height: 26,
              }}
            />
            <View style={styles.space} />
            <SkelletonD
              style={{
                borderRadius: 50,
                width: 50,
                height: 26,
              }}
            />
          </View>
          <View style={styles.space} />
        </React.Fragment>
      ))}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    flexGrow: 1,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 26,
  },
  space: {
    margin: 16,
  },
  spaceSmall: {
    margin: 16,
  },
});
