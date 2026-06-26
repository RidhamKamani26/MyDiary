package com.mydiary.app.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B5\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u001c\u0010\u0015\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0017\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/mydiary/app/adapters/BackgroundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/mydiary/app/adapters/BackgroundAdapter$BgViewHolder;", "items", "", "", "type", "onSelected", "Lkotlin/Function2;", "", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "selectedPos", "", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateItems", "newItems", "newType", "BgViewHolder", "app_debug"})
public final class BackgroundAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.mydiary.app.adapters.BackgroundAdapter.BgViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> items;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String type;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> onSelected = null;
    private int selectedPos = 0;
    
    public BackgroundAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> items, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSelected) {
        super();
    }
    
    public final void updateItems(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> newItems, @org.jetbrains.annotations.NotNull()
    java.lang.String newType) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.mydiary.app.adapters.BackgroundAdapter.BgViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.mydiary.app.adapters.BackgroundAdapter.BgViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/mydiary/app/adapters/BackgroundAdapter$BgViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Lcom/mydiary/app/adapters/BackgroundAdapter;Landroid/view/View;)V", "ivSelected", "Landroid/widget/ImageView;", "vColor", "bind", "", "value", "", "isSelected", "", "app_debug"})
    public final class BgViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View vColor = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView ivSelected = null;
        
        public BgViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        java.lang.String value, boolean isSelected) {
        }
    }
}