# react-native-skelleton

A skelleton solution done in native view, with it you can wrap any view component to enhance your user experience.

## Installation

```sh
npm install react-native-skelleton
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

type SkelletonProps = {
  children?: React.ReactElement;
  color: string;
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

- animation between views are not 100% yet due to current synchronous render of react components.

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
