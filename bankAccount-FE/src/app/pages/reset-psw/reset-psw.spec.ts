import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResetPsw } from './reset-psw';

describe('ResetPsw', () => {
  let component: ResetPsw;
  let fixture: ComponentFixture<ResetPsw>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResetPsw],
    }).compileComponents();

    fixture = TestBed.createComponent(ResetPsw);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
