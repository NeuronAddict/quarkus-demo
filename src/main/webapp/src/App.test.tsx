import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/Supersonic Subatomic Particles/i);
  expect(linkElement).toBeInTheDocument();
});
