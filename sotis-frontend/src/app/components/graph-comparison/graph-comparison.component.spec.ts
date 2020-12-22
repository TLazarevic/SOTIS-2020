import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GraphComparisonComponent } from './graph-comparison.component';

describe('GraphComparisonComponent', () => {
  let component: GraphComparisonComponent;
  let fixture: ComponentFixture<GraphComparisonComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GraphComparisonComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GraphComparisonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
