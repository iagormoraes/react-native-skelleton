import {
  requireNativeComponent,
  StyleSheet,
  View,
  ViewStyle,
} from 'react-native';
import * as React from 'react';

export enum SkelletonRepeatMode {
  RESTART = 1,
  REVERSE = 2,
}

// default is AccelerateDecelerateInterpolator
export type SkelletonInterpolator =
  | 'AccelerateDecelerateInterpolator'
  | 'AccelerateInterpolator'
  | 'AnticipateInterpolator'
  | 'AnticipateOvershootInterpolator'
  | 'BounceInterpolator'
  | 'CycleInterpolator'
  | 'DecelerateInterpolator'
  | 'LinearInterpolator'
  | 'OvershootInterpolator';

export type SkelletonGroupProps = {
  children?: React.ReactElement | React.ReactElement[];
  duration?: number;
  startDelay?: number;
  interpolator?: SkelletonInterpolator;
  style?: ViewStyle;
};

export type SkelletonProps = {
  children?: React.ReactElement | React.ReactElement[];
  color?: string;
  autoStart?: boolean;
  duration?: number;
  startDelay?: number;
  repeatDelay?: number;
  repeatMode?: SkelletonRepeatMode.RESTART | SkelletonRepeatMode.REVERSE;
  repeatCount?: number;
  interpolator?: SkelletonInterpolator;
  style?: ViewStyle;
};

export const SkelletonViewManager = requireNativeComponent<SkelletonProps>(
  'SkelletonView'
);

export const SkelletonGroupManager = requireNativeComponent<SkelletonGroupProps>(
  'SkelletonGroupView'
);

const styles = StyleSheet.create({
  container: { overflow: 'hidden' },
  skelleton: { flex: 1 },
});

export function SkelletonGroupView(props: SkelletonGroupProps) {
  return <SkelletonGroupManager {...props} />;
}

function SkelletonView({ style, ...skelletonProps }: SkelletonProps) {
  return (
    <View style={[styles.container, style]}>
      <SkelletonViewManager {...skelletonProps} style={styles.skelleton} />
    </View>
  );
}

export default SkelletonView;
