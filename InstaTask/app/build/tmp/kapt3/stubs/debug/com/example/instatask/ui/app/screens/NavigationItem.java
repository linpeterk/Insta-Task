package com.example.instatask.ui.app.screens;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f\u0082\u0001\b\u001a\u001b\u001c\u001d\u001e\u001f !\u00a8\u0006\""}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem;", "", "route", "", "icon", "", "title", "(Ljava/lang/String;ILjava/lang/String;)V", "getIcon", "()I", "setIcon", "(I)V", "getRoute", "()Ljava/lang/String;", "setRoute", "(Ljava/lang/String;)V", "getTitle", "setTitle", "EntranceScreen", "Home", "LandingScreen", "Logout", "Profile", "Settings", "SignIn", "SignUp", "Lcom/example/instatask/ui/app/screens/NavigationItem$Home;", "Lcom/example/instatask/ui/app/screens/NavigationItem$Profile;", "Lcom/example/instatask/ui/app/screens/NavigationItem$Settings;", "Lcom/example/instatask/ui/app/screens/NavigationItem$SignIn;", "Lcom/example/instatask/ui/app/screens/NavigationItem$SignUp;", "Lcom/example/instatask/ui/app/screens/NavigationItem$Logout;", "Lcom/example/instatask/ui/app/screens/NavigationItem$LandingScreen;", "Lcom/example/instatask/ui/app/screens/NavigationItem$EntranceScreen;", "app_debug"})
public abstract class NavigationItem {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String route;
    private int icon;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String title;
    
    private NavigationItem(java.lang.String route, int icon, java.lang.String title) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRoute() {
        return null;
    }
    
    public final void setRoute(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getIcon() {
        return 0;
    }
    
    public final void setIcon(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$Home;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class Home extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.Home INSTANCE = null;
        
        private Home() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$Profile;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class Profile extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.Profile INSTANCE = null;
        
        private Profile() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$Settings;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class Settings extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.Settings INSTANCE = null;
        
        private Settings() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$SignIn;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class SignIn extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.SignIn INSTANCE = null;
        
        private SignIn() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$SignUp;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class SignUp extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.SignUp INSTANCE = null;
        
        private SignUp() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$Logout;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class Logout extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.Logout INSTANCE = null;
        
        private Logout() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$LandingScreen;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class LandingScreen extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.LandingScreen INSTANCE = null;
        
        private LandingScreen() {
            super(null, 0, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/example/instatask/ui/app/screens/NavigationItem$EntranceScreen;", "Lcom/example/instatask/ui/app/screens/NavigationItem;", "()V", "app_debug"})
    public static final class EntranceScreen extends com.example.instatask.ui.app.screens.NavigationItem {
        @org.jetbrains.annotations.NotNull()
        public static final com.example.instatask.ui.app.screens.NavigationItem.EntranceScreen INSTANCE = null;
        
        private EntranceScreen() {
            super(null, 0, null);
        }
    }
}