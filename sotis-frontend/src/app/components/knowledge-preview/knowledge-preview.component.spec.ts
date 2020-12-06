import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KnowledgePreviewComponent } from './knowledge-preview.component';

describe('KnowledgePreviewComponent', () => {
  let component: KnowledgePreviewComponent;
  let fixture: ComponentFixture<KnowledgePreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KnowledgePreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KnowledgePreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
