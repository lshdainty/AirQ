cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    {
        "file": "plugins/cordova-plugin-fcm-with-dependecy-updated/www/FCMPlugin.js",
        "id": "cordova-plugin-fcm-with-dependecy-updated.FCMPlugin",
        "pluginId": "cordova-plugin-fcm-with-dependecy-updated",
        "clobbers": [
            "FCMPlugin"
        ]
    },
    {
        "file": "plugins/cordova-plugin-permission/www/index.js",
        "id": "cordova-plugin-permission.Permission",
        "pluginId": "cordova-plugin-permission",
        "clobbers": [
            "window.plugins.Permission"
        ]
    },
    {
        "file": "plugins/cordova-plugin-permission/tests/index.spec.js",
        "id": "cordova-plugin-permission.tests",
        "pluginId": "cordova-plugin-permission"
    }
];
module.exports.metadata = 
// TOP OF METADATA
{
    "cordova-plugin-fcm-with-dependecy-updated": "2.4.0",
    "cordova-plugin-whitelist": "1.3.3",
    "cordova-plugin-geolocation": "4.0.1",
    "cordova-plugin-permission": "0.1.0",
    "cordova.plugins.diagnostic": "4.0.12"
}
// BOTTOM OF METADATA
});