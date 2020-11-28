import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestsPreviewComponent } from './tests-preview.component';

describe('TestsPreviewComponent', () => {
  let component: TestsPreviewComponent;
  let fixture: ComponentFixture<TestsPreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TestsPreviewComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestsPreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
