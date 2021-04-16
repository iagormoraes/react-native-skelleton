import { requireNativeComponent, ViewStyle } from 'react-native';

type SkelletonProps = {
  color: string;
  style: ViewStyle;
};

export const SkelletonViewManager = requireNativeComponent<SkelletonProps>(
'SkelletonView'
);

export default SkelletonViewManager;
