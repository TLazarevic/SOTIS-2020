import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentKnowledgeSpaceComponent } from './student-knowledge-space.component';

describe('StudentKnowledgeSpaceComponent', () => {
  let component: StudentKnowledgeSpaceComponent;
  let fixture: ComponentFixture<StudentKnowledgeSpaceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StudentKnowledgeSpaceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentKnowledgeSpaceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
