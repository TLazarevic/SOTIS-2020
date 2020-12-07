import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPitanjeComponent } from './new-pitanje.component';

describe('NewPitanjeComponent', () => {
  let component: NewPitanjeComponent;
  let fixture: ComponentFixture<NewPitanjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewPitanjeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPitanjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
