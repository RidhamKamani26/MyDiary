package com.mydiary.app.viewmodels;

import com.mydiary.app.repository.DiaryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DiaryViewModel_Factory implements Factory<DiaryViewModel> {
  private final Provider<DiaryRepository> repositoryProvider;

  public DiaryViewModel_Factory(Provider<DiaryRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DiaryViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static DiaryViewModel_Factory create(Provider<DiaryRepository> repositoryProvider) {
    return new DiaryViewModel_Factory(repositoryProvider);
  }

  public static DiaryViewModel newInstance(DiaryRepository repository) {
    return new DiaryViewModel(repository);
  }
}
