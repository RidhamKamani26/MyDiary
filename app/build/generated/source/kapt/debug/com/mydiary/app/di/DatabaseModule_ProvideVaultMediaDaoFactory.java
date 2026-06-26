package com.mydiary.app.di;

import com.mydiary.app.database.DiaryDatabase;
import com.mydiary.app.database.VaultMediaDao;
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
public final class DatabaseModule_ProvideVaultMediaDaoFactory implements Factory<VaultMediaDao> {
  private final Provider<DiaryDatabase> dbProvider;

  public DatabaseModule_ProvideVaultMediaDaoFactory(Provider<DiaryDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public VaultMediaDao get() {
    return provideVaultMediaDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideVaultMediaDaoFactory create(
      Provider<DiaryDatabase> dbProvider) {
    return new DatabaseModule_ProvideVaultMediaDaoFactory(dbProvider);
  }

  public static VaultMediaDao provideVaultMediaDao(DiaryDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideVaultMediaDao(db));
  }
}
