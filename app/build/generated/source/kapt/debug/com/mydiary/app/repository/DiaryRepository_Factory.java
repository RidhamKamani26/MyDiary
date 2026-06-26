package com.mydiary.app.repository;

import com.mydiary.app.database.DiaryNoteDao;
import com.mydiary.app.database.VaultMediaDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DiaryRepository_Factory implements Factory<DiaryRepository> {
  private final Provider<DiaryNoteDao> noteDaoProvider;

  private final Provider<VaultMediaDao> vaultMediaDaoProvider;

  public DiaryRepository_Factory(Provider<DiaryNoteDao> noteDaoProvider,
      Provider<VaultMediaDao> vaultMediaDaoProvider) {
    this.noteDaoProvider = noteDaoProvider;
    this.vaultMediaDaoProvider = vaultMediaDaoProvider;
  }

  @Override
  public DiaryRepository get() {
    return newInstance(noteDaoProvider.get(), vaultMediaDaoProvider.get());
  }

  public static DiaryRepository_Factory create(Provider<DiaryNoteDao> noteDaoProvider,
      Provider<VaultMediaDao> vaultMediaDaoProvider) {
    return new DiaryRepository_Factory(noteDaoProvider, vaultMediaDaoProvider);
  }

  public static DiaryRepository newInstance(DiaryNoteDao noteDao, VaultMediaDao vaultMediaDao) {
    return new DiaryRepository(noteDao, vaultMediaDao);
  }
}
