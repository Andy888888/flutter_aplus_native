//
//  AppDelegate.h
//  AplusFlutter
//
//  Created by 燕文强 on 2019/4/2.
//  Copyright © 2019 燕文强. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <Flutter/Flutter.h>

@interface AppDelegate : FlutterAppDelegate <UIApplicationDelegate, FlutterAppLifeCycleProvider>

@property (strong, nonatomic) UIWindow *window;
@property (nonatomic,strong) FlutterEngine *flutterEngine;

@end

