//
//  FlutterModuleViewController.m
//  AplusFlutter
//
//  Created by 燕文强 on 2019/4/16.
//  Copyright © 2019 燕文强. All rights reserved.
//

#import "FlutterModuleViewController.h"

@interface FlutterModuleViewController ()

@end

@implementation FlutterModuleViewController

- (void)viewWillAppear:(BOOL)animated{
    [self.navigationController setNavigationBarHidden:YES animated:YES];
    [super viewWillAppear:animated];
    
    self.navigationController.interactivePopGestureRecognizer.delegate = (id)self;
    
    FlutterMethodChannel *batteryChannel = [FlutterMethodChannel
                                            methodChannelWithName:@"flutter.io/lifecycle"
                                            binaryMessenger:self];
    
    [batteryChannel setMethodCallHandler:^(FlutterMethodCall * _Nonnull call, FlutterResult  _Nonnull result) {
        if([call.method isEqualToString:@"back"]){
            [self.navigationController popViewControllerAnimated:YES];
        }
    }];
}

-(void) viewWillDisappear:(BOOL)animated{
    [self.navigationController setNavigationBarHidden:NO animated:YES];
    [super viewWillDisappear:animated];
}

- (void)popRoute{
    [self.navigationController popViewControllerAnimated:YES];
}

- (UIView *)splashScreenView{
# warning 重写splashScreenView来处理Native跳转到Flutter页面时，会出现LaunchScreen
    CGRect rect = [UIScreen mainScreen].applicationFrame;
    UIView *view = [[UIView alloc]initWithFrame:rect];
    view.backgroundColor=UIColor.redColor;
    
    return view;
}

@end
