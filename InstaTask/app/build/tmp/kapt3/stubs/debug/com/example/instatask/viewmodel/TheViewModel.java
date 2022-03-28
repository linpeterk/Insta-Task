package com.example.instatask.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u0014J\u0016\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\nJ\u000e\u0010/\u001a\u00020\'2\u0006\u00100\u001a\u00020\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R7\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u001c0\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/example/instatask/viewmodel/TheViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "authService", "Lcom/example/instatask/network/repository/AuthAPIService;", "getAuthService", "()Lcom/example/instatask/network/repository/AuthAPIService;", "categoriesSkill", "", "Lcom/example/instatask/model/Categories;", "getCategoriesSkill", "()Ljava/util/List;", "setCategoriesSkill", "(Ljava/util/List;)V", "categoriesTask", "getCategoriesTask", "setCategoriesTask", "<set-?>", "", "count", "getCount", "()I", "setCount", "(I)V", "count$delegate", "Landroidx/compose/runtime/MutableState;", "Lcom/example/instatask/network/ResponseSkillType;", "currentList", "getCurrentList", "setCurrentList", "currentList$delegate", "loginRequestLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getCategorySkill", "getCategoryTask", "getCatlist", "", "category", "getImageId", "context", "Landroid/content/Context;", "imageName", "", "getTasklist", "up", "value", "app_debug"})
public final class TheViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState count$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.instatask.model.Categories> categoriesTask;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.instatask.model.Categories> categoriesSkill;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState currentList$delegate = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> loginRequestLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.instatask.network.repository.AuthAPIService authService = null;
    
    public TheViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.instatask.model.Categories> getCategoriesTask() {
        return null;
    }
    
    public final void setCategoriesTask(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.instatask.model.Categories> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.instatask.model.Categories> getCategoriesSkill() {
        return null;
    }
    
    public final void setCategoriesSkill(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.instatask.model.Categories> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.instatask.network.ResponseSkillType> getCurrentList() {
        return null;
    }
    
    public final void setCurrentList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.instatask.network.ResponseSkillType> p0) {
    }
    
    public final int getImageId(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String imageName) {
        return 0;
    }
    
    public final void up(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.instatask.model.Categories> getCategoryTask() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.instatask.model.Categories> getCategorySkill() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.instatask.network.ResponseSkillType> getTasklist() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.instatask.network.repository.AuthAPIService getAuthService() {
        return null;
    }
    
    public final void getCatlist(int category) {
    }
}