
第二章 身份验证
----------


http://jinnianshilongnian.iteye.com/blog/2019547#comments


| 目录      	 |类名           |
|:-------------|:------------:|
|2.3  登录/退出   |LoginLogoutTest   |


|	方法名		|说明		|
| :-------------| :-------------|
| testHelloworld| |
|testCustomRealm|单Realm配置|


- 2.1、首先通过new IniSecurityManagerFactory并指定一个ini配置文件来创建一个SecurityManager工厂；
- 2.2、接着获取SecurityManager并绑定到SecurityUtils，这是一个全局设置，设置一次即可；
- 2.3、通过SecurityUtils得到Subject，其会自动绑定到当前线程；如果在web环境在请求结束时需要解除绑定；然后获取身份验证的Token，如用户名/密码；
- 2.4、调用subject.login方法进行登录，其会自动委托给SecurityManager.login方法进行登录；
- 2.5、如果身份验证失败请捕获AuthenticationException或其子类，常见的如： DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库；
- 2.6、最后可以调用subject.logout退出，其会自动委托给SecurityManager.logout方法退出。


| 目录      	 |类名           |
|:-------------|:------------:|
|2.6  Authenticator及AuthenticationStrategy|AuthenticatorTest|


|	方法名		|说明		|
| :-------------| :-------------|
|testAllSuccessfulStrategyWithSuccess|  所有成功|
|testAllSuccessfulStrategyWithFail|  所有成功（失败，因为其中有一个没有成功）|
|testAtLeastOneSuccessfulStrategyWithSuccess|  至少一个成功|
|testFirstOneSuccessfulStrategyWithSuccess|  第一个成功|
|testAtLeastTwoStrategyWithSuccess|  至少两个成功|
|testOnlyOneStrategyWithSuccess| 只有一个成功 |





