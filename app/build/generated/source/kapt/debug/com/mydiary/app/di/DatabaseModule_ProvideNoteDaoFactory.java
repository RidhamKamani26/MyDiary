package com.mydiary.app.di;

import com.mydiary.app.database.DiaryDatabase;
import com.mydiary.app.database.DiaryNoteDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideNoteDaoFactory implements Factory<DiaryNoteDao> {
  private final Provider<DiaryDatabase> dbProvider;

  public DatabaseModule_ProvideNoteDaoFactory(Provider<DiaryDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public DiaryNoteDao get() {
    return provideNoteDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideNoteDaoFactory create(Provider<DiaryDatabase> dbProvider) {
    return new DatabaseModule_ProvideNoteDaoFactory(dbProvider);
  }

  public static DiaryNoteDao provideNoteDao(DiaryDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideNoteDao(db));
  }
}
