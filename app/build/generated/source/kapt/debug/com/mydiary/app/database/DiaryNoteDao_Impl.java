package com.mydiary.app.database;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mydiary.app.models.DiaryNote;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class DiaryNoteDao_Impl implements DiaryNoteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<DiaryNote> __insertionAdapterOfDiaryNote;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<DiaryNote> __deletionAdapterOfDiaryNote;

  private final EntityDeletionOrUpdateAdapter<DiaryNote> __updateAdapterOfDiaryNote;

  private final SharedSQLiteStatement __preparedStmtOfDeleteNoteById;

  public DiaryNoteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDiaryNote = new EntityInsertionAdapter<DiaryNote>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `diary_notes` (`id`,`title`,`description`,`imagePath`,`moodEmoji`,`backgroundType`,`backgroundValue`,`date`,`isPrivate`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DiaryNote entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getImagePath() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImagePath());
        }
        if (entity.getMoodEmoji() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getMoodEmoji());
        }
        if (entity.getBackgroundType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBackgroundType());
        }
        if (entity.getBackgroundValue() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBackgroundValue());
        }
        final Long _tmp = __converters.dateToTimestamp(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, _tmp);
        }
        final int _tmp_1 = entity.isPrivate() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfDiaryNote = new EntityDeletionOrUpdateAdapter<DiaryNote>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `diary_notes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DiaryNote entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfDiaryNote = new EntityDeletionOrUpdateAdapter<DiaryNote>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `diary_notes` SET `id` = ?,`title` = ?,`description` = ?,`imagePath` = ?,`moodEmoji` = ?,`backgroundType` = ?,`backgroundValue` = ?,`date` = ?,`isPrivate` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final DiaryNote entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getDescription() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescription());
        }
        if (entity.getImagePath() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImagePath());
        }
        if (entity.getMoodEmoji() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getMoodEmoji());
        }
        if (entity.getBackgroundType() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getBackgroundType());
        }
        if (entity.getBackgroundValue() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getBackgroundValue());
        }
        final Long _tmp = __converters.dateToTimestamp(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, _tmp);
        }
        final int _tmp_1 = entity.isPrivate() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        statement.bindLong(10, entity.getCreatedAt());
        statement.bindLong(11, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteNoteById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM diary_notes WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertNote(final DiaryNote note, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfDiaryNote.insertAndReturnId(note);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNote(final DiaryNote note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfDiaryNote.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateNote(final DiaryNote note, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfDiaryNote.handle(note);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteNoteById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteNoteById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteNoteById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<DiaryNote>> getAllNotes() {
    final String _sql = "SELECT * FROM diary_notes WHERE isPrivate = 0 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"diary_notes"}, false, new Callable<List<DiaryNote>>() {
      @Override
      @Nullable
      public List<DiaryNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfMoodEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "moodEmoji");
          final int _cursorIndexOfBackgroundType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundType");
          final int _cursorIndexOfBackgroundValue = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "isPrivate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<DiaryNote> _result = new ArrayList<DiaryNote>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DiaryNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpMoodEmoji;
            if (_cursor.isNull(_cursorIndexOfMoodEmoji)) {
              _tmpMoodEmoji = null;
            } else {
              _tmpMoodEmoji = _cursor.getString(_cursorIndexOfMoodEmoji);
            }
            final String _tmpBackgroundType;
            if (_cursor.isNull(_cursorIndexOfBackgroundType)) {
              _tmpBackgroundType = null;
            } else {
              _tmpBackgroundType = _cursor.getString(_cursorIndexOfBackgroundType);
            }
            final String _tmpBackgroundValue;
            if (_cursor.isNull(_cursorIndexOfBackgroundValue)) {
              _tmpBackgroundValue = null;
            } else {
              _tmpBackgroundValue = _cursor.getString(_cursorIndexOfBackgroundValue);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPrivate;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPrivate);
            _tmpIsPrivate = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new DiaryNote(_tmpId,_tmpTitle,_tmpDescription,_tmpImagePath,_tmpMoodEmoji,_tmpBackgroundType,_tmpBackgroundValue,_tmpDate,_tmpIsPrivate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DiaryNote>> getPrivateNotes() {
    final String _sql = "SELECT * FROM diary_notes WHERE isPrivate = 1 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"diary_notes"}, false, new Callable<List<DiaryNote>>() {
      @Override
      @Nullable
      public List<DiaryNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfMoodEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "moodEmoji");
          final int _cursorIndexOfBackgroundType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundType");
          final int _cursorIndexOfBackgroundValue = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "isPrivate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<DiaryNote> _result = new ArrayList<DiaryNote>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DiaryNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpMoodEmoji;
            if (_cursor.isNull(_cursorIndexOfMoodEmoji)) {
              _tmpMoodEmoji = null;
            } else {
              _tmpMoodEmoji = _cursor.getString(_cursorIndexOfMoodEmoji);
            }
            final String _tmpBackgroundType;
            if (_cursor.isNull(_cursorIndexOfBackgroundType)) {
              _tmpBackgroundType = null;
            } else {
              _tmpBackgroundType = _cursor.getString(_cursorIndexOfBackgroundType);
            }
            final String _tmpBackgroundValue;
            if (_cursor.isNull(_cursorIndexOfBackgroundValue)) {
              _tmpBackgroundValue = null;
            } else {
              _tmpBackgroundValue = _cursor.getString(_cursorIndexOfBackgroundValue);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPrivate;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPrivate);
            _tmpIsPrivate = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new DiaryNote(_tmpId,_tmpTitle,_tmpDescription,_tmpImagePath,_tmpMoodEmoji,_tmpBackgroundType,_tmpBackgroundValue,_tmpDate,_tmpIsPrivate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getNoteById(final long id, final Continuation<? super DiaryNote> $completion) {
    final String _sql = "SELECT * FROM diary_notes WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<DiaryNote>() {
      @Override
      @Nullable
      public DiaryNote call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfMoodEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "moodEmoji");
          final int _cursorIndexOfBackgroundType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundType");
          final int _cursorIndexOfBackgroundValue = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "isPrivate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final DiaryNote _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpMoodEmoji;
            if (_cursor.isNull(_cursorIndexOfMoodEmoji)) {
              _tmpMoodEmoji = null;
            } else {
              _tmpMoodEmoji = _cursor.getString(_cursorIndexOfMoodEmoji);
            }
            final String _tmpBackgroundType;
            if (_cursor.isNull(_cursorIndexOfBackgroundType)) {
              _tmpBackgroundType = null;
            } else {
              _tmpBackgroundType = _cursor.getString(_cursorIndexOfBackgroundType);
            }
            final String _tmpBackgroundValue;
            if (_cursor.isNull(_cursorIndexOfBackgroundValue)) {
              _tmpBackgroundValue = null;
            } else {
              _tmpBackgroundValue = _cursor.getString(_cursorIndexOfBackgroundValue);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPrivate;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPrivate);
            _tmpIsPrivate = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new DiaryNote(_tmpId,_tmpTitle,_tmpDescription,_tmpImagePath,_tmpMoodEmoji,_tmpBackgroundType,_tmpBackgroundValue,_tmpDate,_tmpIsPrivate,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<DiaryNote>> getNotesByDate(final long startOfDay, final long endOfDay) {
    final String _sql = "SELECT * FROM diary_notes WHERE date >= ? AND date < ? AND isPrivate = 0 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startOfDay);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endOfDay);
    return __db.getInvalidationTracker().createLiveData(new String[] {"diary_notes"}, false, new Callable<List<DiaryNote>>() {
      @Override
      @Nullable
      public List<DiaryNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfMoodEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "moodEmoji");
          final int _cursorIndexOfBackgroundType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundType");
          final int _cursorIndexOfBackgroundValue = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "isPrivate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<DiaryNote> _result = new ArrayList<DiaryNote>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DiaryNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpMoodEmoji;
            if (_cursor.isNull(_cursorIndexOfMoodEmoji)) {
              _tmpMoodEmoji = null;
            } else {
              _tmpMoodEmoji = _cursor.getString(_cursorIndexOfMoodEmoji);
            }
            final String _tmpBackgroundType;
            if (_cursor.isNull(_cursorIndexOfBackgroundType)) {
              _tmpBackgroundType = null;
            } else {
              _tmpBackgroundType = _cursor.getString(_cursorIndexOfBackgroundType);
            }
            final String _tmpBackgroundValue;
            if (_cursor.isNull(_cursorIndexOfBackgroundValue)) {
              _tmpBackgroundValue = null;
            } else {
              _tmpBackgroundValue = _cursor.getString(_cursorIndexOfBackgroundValue);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPrivate;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPrivate);
            _tmpIsPrivate = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new DiaryNote(_tmpId,_tmpTitle,_tmpDescription,_tmpImagePath,_tmpMoodEmoji,_tmpBackgroundType,_tmpBackgroundValue,_tmpDate,_tmpIsPrivate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<String>> getNoteDates() {
    final String _sql = "SELECT DISTINCT strftime('%Y-%m-%d', date/1000, 'unixepoch') FROM diary_notes WHERE isPrivate = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"diary_notes"}, false, new Callable<List<String>>() {
      @Override
      @Nullable
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final String _item;
            final String _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(0);
            }
            _item = _tmp;
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DiaryNote>> searchNotes(final String query) {
    final String _sql = "SELECT * FROM diary_notes WHERE (title LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%') AND isPrivate = 0 ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"diary_notes"}, false, new Callable<List<DiaryNote>>() {
      @Override
      @Nullable
      public List<DiaryNote> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "imagePath");
          final int _cursorIndexOfMoodEmoji = CursorUtil.getColumnIndexOrThrow(_cursor, "moodEmoji");
          final int _cursorIndexOfBackgroundType = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundType");
          final int _cursorIndexOfBackgroundValue = CursorUtil.getColumnIndexOrThrow(_cursor, "backgroundValue");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfIsPrivate = CursorUtil.getColumnIndexOrThrow(_cursor, "isPrivate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<DiaryNote> _result = new ArrayList<DiaryNote>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final DiaryNote _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            final String _tmpMoodEmoji;
            if (_cursor.isNull(_cursorIndexOfMoodEmoji)) {
              _tmpMoodEmoji = null;
            } else {
              _tmpMoodEmoji = _cursor.getString(_cursorIndexOfMoodEmoji);
            }
            final String _tmpBackgroundType;
            if (_cursor.isNull(_cursorIndexOfBackgroundType)) {
              _tmpBackgroundType = null;
            } else {
              _tmpBackgroundType = _cursor.getString(_cursorIndexOfBackgroundType);
            }
            final String _tmpBackgroundValue;
            if (_cursor.isNull(_cursorIndexOfBackgroundValue)) {
              _tmpBackgroundValue = null;
            } else {
              _tmpBackgroundValue = _cursor.getString(_cursorIndexOfBackgroundValue);
            }
            final Date _tmpDate;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromTimestamp(_tmp);
            final boolean _tmpIsPrivate;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsPrivate);
            _tmpIsPrivate = _tmp_1 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new DiaryNote(_tmpId,_tmpTitle,_tmpDescription,_tmpImagePath,_tmpMoodEmoji,_tmpBackgroundType,_tmpBackgroundValue,_tmpDate,_tmpIsPrivate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
