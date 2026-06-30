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
import com.mydiary.app.models.VaultMedia;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class VaultMediaDao_Impl implements VaultMediaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<VaultMedia> __insertionAdapterOfVaultMedia;

  private final EntityDeletionOrUpdateAdapter<VaultMedia> __deletionAdapterOfVaultMedia;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMediaById;

  public VaultMediaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfVaultMedia = new EntityInsertionAdapter<VaultMedia>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `vault_media` (`id`,`originalPath`,`vaultPath`,`mediaType`,`fileName`,`addedAt`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VaultMedia entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getOriginalPath() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getOriginalPath());
        }
        if (entity.getVaultPath() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getVaultPath());
        }
        if (entity.getMediaType() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getMediaType());
        }
        if (entity.getFileName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getFileName());
        }
        statement.bindLong(6, entity.getAddedAt());
      }
    };
    this.__deletionAdapterOfVaultMedia = new EntityDeletionOrUpdateAdapter<VaultMedia>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `vault_media` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final VaultMedia entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteMediaById = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM vault_media WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertMedia(final VaultMedia media, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfVaultMedia.insertAndReturnId(media);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMedia(final VaultMedia media, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfVaultMedia.handle(media);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteMediaById(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMediaById.acquire();
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
          __preparedStmtOfDeleteMediaById.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<VaultMedia>> getMediaByType(final String type) {
    final String _sql = "SELECT * FROM vault_media WHERE mediaType = ? ORDER BY addedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (type == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, type);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"vault_media"}, false, new Callable<List<VaultMedia>>() {
      @Override
      @Nullable
      public List<VaultMedia> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "originalPath");
          final int _cursorIndexOfVaultPath = CursorUtil.getColumnIndexOrThrow(_cursor, "vaultPath");
          final int _cursorIndexOfMediaType = CursorUtil.getColumnIndexOrThrow(_cursor, "mediaType");
          final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "fileName");
          final int _cursorIndexOfAddedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "addedAt");
          final List<VaultMedia> _result = new ArrayList<VaultMedia>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VaultMedia _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpOriginalPath;
            if (_cursor.isNull(_cursorIndexOfOriginalPath)) {
              _tmpOriginalPath = null;
            } else {
              _tmpOriginalPath = _cursor.getString(_cursorIndexOfOriginalPath);
            }
            final String _tmpVaultPath;
            if (_cursor.isNull(_cursorIndexOfVaultPath)) {
              _tmpVaultPath = null;
            } else {
              _tmpVaultPath = _cursor.getString(_cursorIndexOfVaultPath);
            }
            final String _tmpMediaType;
            if (_cursor.isNull(_cursorIndexOfMediaType)) {
              _tmpMediaType = null;
            } else {
              _tmpMediaType = _cursor.getString(_cursorIndexOfMediaType);
            }
            final String _tmpFileName;
            if (_cursor.isNull(_cursorIndexOfFileName)) {
              _tmpFileName = null;
            } else {
              _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
            }
            final long _tmpAddedAt;
            _tmpAddedAt = _cursor.getLong(_cursorIndexOfAddedAt);
            _item = new VaultMedia(_tmpId,_tmpOriginalPath,_tmpVaultPath,_tmpMediaType,_tmpFileName,_tmpAddedAt);
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
  public LiveData<List<VaultMedia>> getAllMedia() {
    final String _sql = "SELECT * FROM vault_media ORDER BY addedAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"vault_media"}, false, new Callable<List<VaultMedia>>() {
      @Override
      @Nullable
      public List<VaultMedia> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "originalPath");
          final int _cursorIndexOfVaultPath = CursorUtil.getColumnIndexOrThrow(_cursor, "vaultPath");
          final int _cursorIndexOfMediaType = CursorUtil.getColumnIndexOrThrow(_cursor, "mediaType");
          final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "fileName");
          final int _cursorIndexOfAddedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "addedAt");
          final List<VaultMedia> _result = new ArrayList<VaultMedia>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final VaultMedia _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpOriginalPath;
            if (_cursor.isNull(_cursorIndexOfOriginalPath)) {
              _tmpOriginalPath = null;
            } else {
              _tmpOriginalPath = _cursor.getString(_cursorIndexOfOriginalPath);
            }
            final String _tmpVaultPath;
            if (_cursor.isNull(_cursorIndexOfVaultPath)) {
              _tmpVaultPath = null;
            } else {
              _tmpVaultPath = _cursor.getString(_cursorIndexOfVaultPath);
            }
            final String _tmpMediaType;
            if (_cursor.isNull(_cursorIndexOfMediaType)) {
              _tmpMediaType = null;
            } else {
              _tmpMediaType = _cursor.getString(_cursorIndexOfMediaType);
            }
            final String _tmpFileName;
            if (_cursor.isNull(_cursorIndexOfFileName)) {
              _tmpFileName = null;
            } else {
              _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
            }
            final long _tmpAddedAt;
            _tmpAddedAt = _cursor.getLong(_cursorIndexOfAddedAt);
            _item = new VaultMedia(_tmpId,_tmpOriginalPath,_tmpVaultPath,_tmpMediaType,_tmpFileName,_tmpAddedAt);
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
  public Object getMediaById(final long id, final Continuation<? super VaultMedia> $completion) {
    final String _sql = "SELECT * FROM vault_media WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<VaultMedia>() {
      @Override
      @Nullable
      public VaultMedia call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfOriginalPath = CursorUtil.getColumnIndexOrThrow(_cursor, "originalPath");
          final int _cursorIndexOfVaultPath = CursorUtil.getColumnIndexOrThrow(_cursor, "vaultPath");
          final int _cursorIndexOfMediaType = CursorUtil.getColumnIndexOrThrow(_cursor, "mediaType");
          final int _cursorIndexOfFileName = CursorUtil.getColumnIndexOrThrow(_cursor, "fileName");
          final int _cursorIndexOfAddedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "addedAt");
          final VaultMedia _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpOriginalPath;
            if (_cursor.isNull(_cursorIndexOfOriginalPath)) {
              _tmpOriginalPath = null;
            } else {
              _tmpOriginalPath = _cursor.getString(_cursorIndexOfOriginalPath);
            }
            final String _tmpVaultPath;
            if (_cursor.isNull(_cursorIndexOfVaultPath)) {
              _tmpVaultPath = null;
            } else {
              _tmpVaultPath = _cursor.getString(_cursorIndexOfVaultPath);
            }
            final String _tmpMediaType;
            if (_cursor.isNull(_cursorIndexOfMediaType)) {
              _tmpMediaType = null;
            } else {
              _tmpMediaType = _cursor.getString(_cursorIndexOfMediaType);
            }
            final String _tmpFileName;
            if (_cursor.isNull(_cursorIndexOfFileName)) {
              _tmpFileName = null;
            } else {
              _tmpFileName = _cursor.getString(_cursorIndexOfFileName);
            }
            final long _tmpAddedAt;
            _tmpAddedAt = _cursor.getLong(_cursorIndexOfAddedAt);
            _result = new VaultMedia(_tmpId,_tmpOriginalPath,_tmpVaultPath,_tmpMediaType,_tmpFileName,_tmpAddedAt);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
