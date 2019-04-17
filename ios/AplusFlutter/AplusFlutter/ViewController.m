//
//  ViewController.m
//  AplusFlutter
//
//  Created by 燕文强 on 2019/4/2.
//  Copyright © 2019 燕文强. All rights reserved.
//

#import "ViewController.h"
#import "AppDelegate.h"
#import "FlutterModuleViewController.h"


@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
}
- (IBAction)editProperty:(id)sender {
    FlutterModuleViewController *flutterViewController = [[FlutterModuleViewController alloc] initWithProject:nil nibName:nil bundle:nil];
    [flutterViewController setInitialRoute:@"edit-property?{\"keyId\":\"123\",\"trustType\":2}"];
    [self.navigationController pushViewController:flutterViewController animated:YES];
}

- (IBAction)click:(id)sender {
    FlutterModuleViewController *flutterViewController = [[FlutterModuleViewController alloc] initWithProject:nil nibName:nil bundle:nil];
    [flutterViewController setInitialRoute:@"grid?{\"keyId\":\"123\",\"trustType\":2}"];
//    [self presentViewController:flutterViewController animated:YES completion:nil];
    [self.navigationController pushViewController:flutterViewController animated:YES];
}


@end
