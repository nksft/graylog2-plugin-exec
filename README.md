# graylog2-plugin-exec
An alarm callback plugin for executing a script on Graylog2's server.

## Installation

[Download the plugin](https://github.com/nksft/graylog2-plugin-exec/releases)
and place the `.jar` file in your Graylog plugin directory. The plugin directory
is the `plugins/` folder relative from your `graylog-server` directory by default
and can be configured in your `graylog.conf` file.

Restart `graylog-server` and you are done.

## Usage

Create a "Execute Command Alarm Callback" on the "Manage alerts" page of your stream.
Enter the requested configuration and save.
Make sure you also configured alert conditions for the stream so that the alerts are actually triggered.

## Example

For calling the script /root/script.php and passing it a parameter just fill the box like this:
php /root/script.php param1

## Build

This project is using Maven and requires Java 7 or higher.

You can build a plugin (JAR) with `mvn package`.

## Copyright

Copyright (c) 2016 Ahmad Niksefat. See LICENSE for further details.
