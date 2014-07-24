package ludia.sessionm {
import flash.events.IEventDispatcher;

import ludia.sessionm.data.Achievement;

import ludia.sessionm.data.User;

/**
 * Provides access to the SessionM Adobe AIR native extension package's
 * functions to an ActionScript application (implemented by
 * <code>SessionM</code>).
 *
 * @see SessionM
 */
public interface ISessionM extends IEventDispatcher {
    function shouldDisplayRewardsBadge():Boolean;
    function logAction(action:String):void;
    function initActivity(type:String):void;
    function initCustomActivity():void;
    function notifyDismissedAchievement(dismissType:String):void;
    function startSession(appID:String):void;
    function getUser():User;
    function getUnclaimedAchievement():Achievement;
    function isSupportedPlatform():Boolean;
    function getSDKVersion():String;
    function getExtensionVersion():String;
    function getPlatform():String;
}
}
