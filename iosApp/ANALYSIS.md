### Static code analysis

#### iOS
iOS code analysis useses [SwiftLint](https://github.com/realm/SwiftLint). This is added as a dependency to the `Podfile` and requires the user to install this dependency by using:

`pod install`

After that you should be able to run code analysis using fastlane like so: 

`fastlane lint`

This would provide a code analysis report. The initial configuration of lint rules can be found in `.swiftlint.yml`. Additional configuration of the rules can be performed according to [the documentation](https://github.com/realm/SwiftLint#configuration)

Swiftlint also allows for automatic formatting of the codebase. To perform this action you need to run: 

`fastlane lint_autocorrect`
