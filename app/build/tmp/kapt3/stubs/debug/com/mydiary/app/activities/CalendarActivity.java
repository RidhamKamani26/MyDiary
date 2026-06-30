package com.mydiary.app.activities;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\u0012\u0010&\u001a\u00020 2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020 H\u0014J\b\u0010*\u001a\u00020 H\u0002J\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00060"}, d2 = {"Lcom/mydiary/app/activities/CalendarActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "calendarDayAdapter", "Lcom/mydiary/app/adapters/CalendarDayAdapter;", "displayedMonth", "", "displayedYear", "gridCalendar", "Landroid/widget/GridView;", "layoutNoEntries", "Landroid/view/View;", "noteDates", "", "", "notesAdapter", "Lcom/mydiary/app/adapters/NotesAdapter;", "rvNotes", "Landroidx/recyclerview/widget/RecyclerView;", "selectedDay", "selectedMonth", "selectedYear", "tvMonthYear", "Landroid/widget/TextView;", "tvSelectedDate", "viewModel", "Lcom/mydiary/app/viewmodels/DiaryViewModel;", "getViewModel", "()Lcom/mydiary/app/viewmodels/DiaryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindViews", "", "buildDays", "", "Lcom/mydiary/app/adapters/CalendarDay;", "loadNotesForSelected", "observeAllNoteDates", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "rebuildCalendar", "setupCalendar", "setupNavigation", "setupNotesList", "updateMonthYearLabel", "updateSelectedLabel", "app_debug"})
public final class CalendarActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private int displayedYear;
    private int displayedMonth;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> noteDates = null;
    private com.mydiary.app.adapters.CalendarDayAdapter calendarDayAdapter;
    private com.mydiary.app.adapters.NotesAdapter notesAdapter;
    private android.widget.TextView tvMonthYear;
    private android.widget.TextView tvSelectedDate;
    private android.widget.GridView gridCalendar;
    private androidx.recyclerview.widget.RecyclerView rvNotes;
    private android.view.View layoutNoEntries;
    
    public CalendarActivity() {
        super();
    }
    
    private final com.mydiary.app.viewmodels.DiaryViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bindViews() {
    }
    
    private final void setupNotesList() {
    }
    
    private final void setupNavigation() {
    }
    
    private final void setupCalendar() {
    }
    
    private final void rebuildCalendar() {
    }
    
    /**
     * Builds the full 6×7 = 42 cell list for [displayedYear]/[displayedMonth].
     * Fills leading/trailing days from adjacent months as filler cells (dayNumber=0
     * unless we want them shown as dim numbers like in the design).
     */
    private final java.util.List<com.mydiary.app.adapters.CalendarDay> buildDays() {
        return null;
    }
    
    private final void updateMonthYearLabel() {
    }
    
    private final void updateSelectedLabel() {
    }
    
    private final void observeAllNoteDates() {
    }
    
    private final void loadNotesForSelected() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
}