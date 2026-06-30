package com.mydiary.app.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u001b\u001cB!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\u0015\u001a\u00020\b2\n\u0010\u0016\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u001c\u0010\u0017\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\n\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/mydiary/app/adapters/VaultMediaAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/mydiary/app/models/VaultMedia;", "Lcom/mydiary/app/adapters/VaultMediaAdapter$MediaViewHolder;", "mediaType", "", "onDelete", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onItemTap", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "media", "", "position", "getOnItemTap", "()Lkotlin/jvm/functions/Function2;", "setOnItemTap", "(Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MediaViewHolder", "app_debug"})
public final class VaultMediaAdapter extends androidx.recyclerview.widget.ListAdapter<com.mydiary.app.models.VaultMedia, com.mydiary.app.adapters.VaultMediaAdapter.MediaViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mediaType = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.mydiary.app.models.VaultMedia, kotlin.Unit> onDelete = null;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function2<? super com.mydiary.app.models.VaultMedia, ? super java.lang.Integer, kotlin.Unit> onItemTap;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.mydiary.app.models.VaultMedia> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.mydiary.app.adapters.VaultMediaAdapter.Companion Companion = null;
    
    public VaultMediaAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mydiary.app.models.VaultMedia, kotlin.Unit> onDelete) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function2<com.mydiary.app.models.VaultMedia, java.lang.Integer, kotlin.Unit> getOnItemTap() {
        return null;
    }
    
    public final void setOnItemTap(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super com.mydiary.app.models.VaultMedia, ? super java.lang.Integer, kotlin.Unit> p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.mydiary.app.adapters.VaultMediaAdapter.MediaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.adapters.VaultMediaAdapter.MediaViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/mydiary/app/adapters/VaultMediaAdapter$Companion;", "", "()V", "DIFF", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/mydiary/app/models/VaultMedia;", "getDIFF", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.mydiary.app.models.VaultMedia> getDIFF() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2 = {"Lcom/mydiary/app/adapters/VaultMediaAdapter$MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/adapters/VaultMediaAdapter;Landroid/view/View;)V", "bind", "", "media", "Lcom/mydiary/app/models/VaultMedia;", "position", "", "app_debug"})
    public final class MediaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public MediaViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.mydiary.app.models.VaultMedia media, int position) {
        }
    }
}