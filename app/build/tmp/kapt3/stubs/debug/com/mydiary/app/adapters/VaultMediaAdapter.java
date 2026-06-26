package com.mydiary.app.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\u00020\b2\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/mydiary/app/adapters/VaultMediaAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/mydiary/app/models/VaultMedia;", "Lcom/mydiary/app/adapters/VaultMediaAdapter$MediaViewHolder;", "mediaType", "", "onDelete", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "MediaViewHolder", "app_debug"})
public final class VaultMediaAdapter extends androidx.recyclerview.widget.ListAdapter<com.mydiary.app.models.VaultMedia, com.mydiary.app.adapters.VaultMediaAdapter.MediaViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mediaType = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.mydiary.app.models.VaultMedia, kotlin.Unit> onDelete = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.mydiary.app.models.VaultMedia> DIFF = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.mydiary.app.adapters.VaultMediaAdapter.Companion Companion = null;
    
    public VaultMediaAdapter(@org.jetbrains.annotations.NotNull()
    java.lang.String mediaType, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.mydiary.app.models.VaultMedia, kotlin.Unit> onDelete) {
        super(null);
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/mydiary/app/adapters/VaultMediaAdapter$MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/adapters/VaultMediaAdapter;Landroid/view/View;)V", "bind", "", "media", "Lcom/mydiary/app/models/VaultMedia;", "app_debug"})
    public final class MediaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public MediaViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.mydiary.app.models.VaultMedia media) {
        }
    }
}