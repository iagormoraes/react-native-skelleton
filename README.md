# react-native-skelleton

A skelleton solution done in native view, with it you can wrap any view component to enhance your user experience.

<img src="./rn-skelleton example.gif" width="400px"/>

## Installation

##### NPM
```sh
npm install react-native-skelleton
```

##### Yarn
```sh
yarn add react-native-skelleton
```

## Usage

```typescript jsx
import SkelletonView from 'react-native-skelleton';

...
render() {
  return(
    <SkelletonView
        color="#00000000"
        repeatCount={-1}
        repeatMode={1}
        duration={1000}
        style={{
            ...style,
            backgroundColor: '#C3C3C3',
        }}
    >
  )
}
```

### With SkelletonGroupView

```typescript jsx
import SkelletonView, { SkelletonGroupView } from 'react-native-skelleton';

render() {
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
  )
}
```
This component accepts any children component class, it will search recursively for the SkelletonView class and animate them.

⚠️ Use this if you to animate a group of skeletons in sync, without it they will not be in sync as the timer is not controlled by the AnimatorSet.

## Props and types

```typescript
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
```

## Known Issues

- animation between views that are not wrapped with SkelletonGroupView is not 100% in sync.
- repeatDelay only works without using SkelletonGroupView.

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
